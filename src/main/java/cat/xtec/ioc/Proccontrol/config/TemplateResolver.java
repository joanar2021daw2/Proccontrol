/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.Proccontrol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Classe que dona a coneixer els sub-directoris de les Templates (pàgines html)
 * que creem per organitzar-les
 * 
 * @author JoseAndrade
 */
@Configuration
public class TemplateResolver {

    /*-----------Mapeja el directori template instalacio-----------*/
    @Bean
    public ClassLoaderTemplateResolver instalacioTemplateResolver() {
        ClassLoaderTemplateResolver instalacioTemplateResolver = new ClassLoaderTemplateResolver();
        instalacioTemplateResolver.setPrefix("templates/instalacio/");
        instalacioTemplateResolver.setSuffix(".html");
        instalacioTemplateResolver.setTemplateMode(TemplateMode.HTML);
        instalacioTemplateResolver.setCharacterEncoding("UTF-8");
        instalacioTemplateResolver.setOrder(1);
        instalacioTemplateResolver.setCheckExistence(true);

        return instalacioTemplateResolver;
    }

    /*-----------Mapeja el directori template seccio-----------*/
    @Bean
    public ClassLoaderTemplateResolver seccioTemplateResolver() {
        ClassLoaderTemplateResolver seccioTemplateResolver = new ClassLoaderTemplateResolver();
        seccioTemplateResolver.setPrefix("templates/seccio/");
        seccioTemplateResolver.setSuffix(".html");
        seccioTemplateResolver.setTemplateMode(TemplateMode.HTML);
        seccioTemplateResolver.setCharacterEncoding("UTF-8");
        seccioTemplateResolver.setOrder(1);
        seccioTemplateResolver.setCheckExistence(true);

        return seccioTemplateResolver;
    }

    /*-----------Mapeja el directori template user-----------*/
    @Bean
    public ClassLoaderTemplateResolver userTemplateResolver() {
        ClassLoaderTemplateResolver userTemplateResolver = new ClassLoaderTemplateResolver();
        userTemplateResolver.setPrefix("templates/user/");
        userTemplateResolver.setSuffix(".html");
        userTemplateResolver.setTemplateMode(TemplateMode.HTML);
        userTemplateResolver.setCharacterEncoding("UTF-8");
        userTemplateResolver.setOrder(1);
        userTemplateResolver.setCheckExistence(true);

        return userTemplateResolver;
    }

    /*-----------Mapeja el directori template proces-----------*/
    @Bean
    public ClassLoaderTemplateResolver procesemplateResolver() {
        ClassLoaderTemplateResolver processosTemplateResolver = new ClassLoaderTemplateResolver();
        processosTemplateResolver.setPrefix("templates/proces/");
        processosTemplateResolver.setSuffix(".html");
        processosTemplateResolver.setTemplateMode(TemplateMode.HTML);
        processosTemplateResolver.setCharacterEncoding("UTF-8");
        processosTemplateResolver.setOrder(1);
        processosTemplateResolver.setCheckExistence(true);

        return processosTemplateResolver;
    }

    /*-----------Mapeja el directori template referencia-----------*/
    @Bean
    public ClassLoaderTemplateResolver referenciaTemplateResolver() {
        ClassLoaderTemplateResolver referenciesTemplateResolver = new ClassLoaderTemplateResolver();
        referenciesTemplateResolver.setPrefix("templates/referencia/");
        referenciesTemplateResolver.setSuffix(".html");
        referenciesTemplateResolver.setTemplateMode(TemplateMode.HTML);
        referenciesTemplateResolver.setCharacterEncoding("UTF-8");
        referenciesTemplateResolver.setOrder(1);
        referenciesTemplateResolver.setCheckExistence(true);

        return referenciesTemplateResolver;
    }
    
        /*-----------Mapeja el directori template resultat-----------*/
    @Bean
    public ClassLoaderTemplateResolver resultatTemplateResolver() {
        ClassLoaderTemplateResolver referenciesTemplateResolver = new ClassLoaderTemplateResolver();
        referenciesTemplateResolver.setPrefix("templates/resultat/");
        referenciesTemplateResolver.setSuffix(".html");
        referenciesTemplateResolver.setTemplateMode(TemplateMode.HTML);
        referenciesTemplateResolver.setCharacterEncoding("UTF-8");
        referenciesTemplateResolver.setOrder(1);
        referenciesTemplateResolver.setCheckExistence(true);

        return referenciesTemplateResolver;
    }
}
