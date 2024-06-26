package xast.spring.dao;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import xast.spring.models.Book;
import xast.spring.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

      private final JdbcTemplate jdbcTemplate;

      @Autowired
      public PersonDAO(JdbcTemplate jdbcTemplate) {
          this.jdbcTemplate = jdbcTemplate;
      }

      public List<Person> index() {
          return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
      }

      public Person show(int id){
          return jdbcTemplate.query("SELECT * FROM Person WHERE id = ?", new Object[]{id},
                  new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
      }

      public void save(Person person){
          jdbcTemplate.update("INSERT INTO Person (fullName, data_born) VALUES (?,?)",
                  person.getFullName(), person.getData_born());
      }

      public void update(int id, Person updatedPerson){
          jdbcTemplate.update("UPDATE Person SET fullName = ?, data_born = ? WHERE id = ?",
                  updatedPerson.getFullName(),updatedPerson.getData_born(), id);
      }

         public void delete(int id){
          jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
      }

      public List<Book> getBookByPersonId(int id){
          return jdbcTemplate.query("SELECT * FROM Book WHERE person_id = ?", new Object[]{id},
                  new BeanPropertyRowMapper<>(Book.class));
      }
}

