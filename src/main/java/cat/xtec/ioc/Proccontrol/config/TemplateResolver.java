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

    /**
     * Mapeja el directori template instalacio
     *
     * @return objecte classloaderTemplateResolver amb les dades de la ruta
     */
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

    /**
     * Mapeja el directori template seccio
     *
     * @return objecte classloaderTemplateResolver amb les dades de la ruta
     */
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

    /**
     * Mapeja el directori template user
     *
     * @return objecte classloaderTemplateResolver amb les dades de la ruta
     */
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

    /**
     * Mapeja el directori template proces
     *
     * @return objecte classloaderTemplateResolver amb les dades de la ruta
     */
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

    /**
     * Mapeja el directori template referencia
     *
     * @return objecte classloaderTemplateResolver amb les dades de la ruta
     */
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

    /**
     * Mapeja el directori template referencia
     *
     * @return objecte classloaderTemplateResolver amb les dades de la ruta
     */
    @Bean
    public ClassLoaderTemplateResolver resultatTemplateResolver() {
        ClassLoaderTemplateResolver resultatTemplateResolver = new ClassLoaderTemplateResolver();
        resultatTemplateResolver.setPrefix("templates/resultat/");
        resultatTemplateResolver.setSuffix(".html");
        resultatTemplateResolver.setTemplateMode(TemplateMode.HTML);
        resultatTemplateResolver.setCharacterEncoding("UTF-8");
        resultatTemplateResolver.setOrder(1);
        resultatTemplateResolver.setCheckExistence(true);

        return resultatTemplateResolver;
    }

    /**
     * Mapeja el directori template compteUsuariBaixa
     *
     * @return objecte classloaderTemplateResolver amb les dades de la ruta
     */
    @Bean
    public ClassLoaderTemplateResolver compteUsuariBaixaTemplateResolver() {
        ClassLoaderTemplateResolver compteUsuariBaixaTemplateResolver = new ClassLoaderTemplateResolver();
        compteUsuariBaixaTemplateResolver.setPrefix("templates/comptesUsuariBaixa/");
        compteUsuariBaixaTemplateResolver.setSuffix(".html");
        compteUsuariBaixaTemplateResolver.setTemplateMode(TemplateMode.HTML);
        compteUsuariBaixaTemplateResolver.setCharacterEncoding("UTF-8");
        compteUsuariBaixaTemplateResolver.setOrder(1);
        compteUsuariBaixaTemplateResolver.setCheckExistence(true);

        return compteUsuariBaixaTemplateResolver;
    }
}
