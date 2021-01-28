package ru.otus.architect.user.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import ru.otus.architect.user.model.User;

@CrossOrigin
@RepositoryRestResource(path = "user")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
