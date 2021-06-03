#1. Create a new spring boot project with web starter dependency (pom.xml)
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

#2. Add debug log for more information (application.properties):
logging.level.org.springframework.security=DEBUG
		
#3. Add HelloController with 3 simple REST API as following:
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() 
    {
        return "Hello";
    }
    
    @GetMapping("/data")
    public String data() 
    {
        return "Data";
    }
	
	@GetMapping("/admin")
    public String admin() 
    {
        return "Admin";
    }
}

#4. add swagger 3 to pom.xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.9</version>
</dependency>

Now we can access swagger at default location: http://localhost:8080/swagger-ui.html
Run and test.

#5. Add security dependency
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
				<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		
#6. Config Security
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("pass")).authorities("ROLE_USER").
		and().
		withUser("admin").password(passwordEncoder().encode("admin")).authorities("ROLE_ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/hello", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll().anyRequest()
				.authenticated().and().httpBasic();
	}

}

#7. Open incognito window http://localhost:8080/swagger-ui.html and test  basicsecurity

#8. Check role 
Add API to Controller that need role    
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin() 
    {
        return "Admin";
    }
Config global security
@EnableGlobalMethodSecurity(prePostEnabled = true)
Open incognito window http://localhost:8080/swagger-ui.html and test  basicsecurity again