package prog2.cerveceria;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("prog2.cerveceria")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry reg) {
        reg.addResourceHandler("/**").addResourceLocations("/");
       // reg.addResourceHandler("/css/**").addResourceLocations("/css/");
       // reg.addResourceHandler("/images/**").addResourceLocations("/images/");
    }
    
 

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setViewClass(JstlView.class);
        vr.setPrefix("/vistas/");
        vr.setSuffix(".jsp");
        return vr;
    }

    @Bean(name = "dbName")
    public String getDBName() {
        return "cerveceria";
    }

    @Bean(name = "dbURL")
    public String getDBURL() {
        return "127.0.1.0";
    }

    @Bean(name = "dbUser")
    public String getDBUser() {
        return "root";
    }

    @Bean(name = "dbPswd")
    public String getDBPswd() {
        return "";
    }
}
