package br.com.baseapp.controllers.api.v1;

import br.com.baseapp.components.Utils;
import br.com.baseapp.domains.User;
import br.com.baseapp.dtos.users.UserCreateDto;
import br.com.baseapp.dtos.users.UserUpdateDto;
import br.com.baseapp.exceptions.BadRequestException;
import br.com.baseapp.repositories.UsersRepository;
import br.com.baseapp.services.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UsersController {

  private UsersRepository userRepository;
  private UsersService userService;
  private ModelMapper modelMapper;

  // @GetMapping("/")
  // public List<User> list() {
  //     return userService.listAll();
  // }

  @GetMapping("/")
  public ResponseEntity<List<User>> list() {
    // return userService.listAll();
    //
    //
    return ResponseEntity.ok(userService.listAll());
  }


  @GetMapping("/paginate")
  @Operation(summary = "List all users paginated", description = "The default size is 5, use the parameter size to change the default value", tags = {"users"})
  // public ResponseEntity<Page<User>> paginate(@Parameter(required = false) Pageable pageable) {
  public ResponseEntity<Page<User>> paginate(@Parameter(hidden = true) Pageable pageable) {
    return ResponseEntity.ok(userService.paginate(pageable));
  }


  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  @PreAuthorize("hasRole('ADMIN')")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Successful Operation"),
    @ApiResponse(responseCode = "400", description = "When Anime Does Not Exist in The Database")
})
  public User create(@RequestBody @Valid UserCreateDto userDto) {
    User user = modelMapper.map(userDto, User.class);
    return userService.create(user);
  }

  // @PostMapping("/")
  // @ResponseStatus(HttpStatus.CREATED)
  // @ResponseBody
  // public User create(@RequestBody @Valid User u) {
  //   u.setPassword((new BCryptPasswordEncoder()).encode(u.getPassword()));

  //   // return new ResponseEntity<>(userRepository.save(u), HttpStatus.CREATED);
  //   return userRepository.save(u);
  // }

  @GetMapping("/{id}")
  public User findById(@PathVariable("id") UUID id) {
    return userRepository
      .findById(id)
      .orElseThrow(() -> new BadRequestException("Entity not fount."));

      // .orElseThrow(
      //   () ->
      //     new ResponseStatusException(
      //       HttpStatus.BAD_REQUEST,
      //       "Entity not fount."
      //     )
      // );
      
    // Optional<User> u = userRepository.findById(id);

    // if (u.isPresent())
    //     return u.get();

    // new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity not fount.");
    // return null;
  }

  @GetMapping("/findByName/{name}")
  public List<User> findByName(@PathVariable("name") String name) {
    return userRepository.findBySimilarityName(name);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @ResponseBody
  public User update(@RequestBody @Valid UserUpdateDto userUpdateDto, @PathVariable("id") UUID id) {
    User localUser = userRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Entity ID not fount."
          )
      );

    User updatedUser = modelMapper.map(userUpdateDto, User.class);
    if (updatedUser.getPassword() != null) {
      updatedUser.setPassword((new BCryptPasswordEncoder()).encode(updatedUser.getPassword()));
    }

    Utils.copyNonNullProperties(updatedUser, localUser);
    return userRepository.save(localUser);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") UUID id) {
    userService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
