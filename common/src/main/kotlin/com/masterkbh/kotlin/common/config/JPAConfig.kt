package com.masterkbh.kotlin.common.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import javax.sql.DataSource

// get yaml properties                              :  https://www.baeldung.com/spring-yaml-propertysource
// get yaml properties by @ConfigurationProperties   : https://rutgo-letsgo.tistory.com/93
// jdbc connection pool                             : https://kakaocommerce.tistory.com/45
//                                                    https://jojoldu.tistory.com/296
// multi db setting                                 : http://millky.com/@origoni/post/1150
// another setting                                  : https://basketdeveloper.tistory.com/74


/*@Configuration
@EnableJpaRepositories(basePackages = ["com.masterkbh.kotlin.common.repository"])*/
class JPAConfig {

    //todo : db properties 작업
    @Bean
    @Primary
    fun dataSource(): DataSource {
        return HikariDataSource(HikariConfig())
    }
    //todo : jpa properties 작업
    @Bean
    @Primary
    fun jpaProperties(): JpaProperties {
        return JpaProperties()
    }

    @Bean
    @Primary
    fun entityManagerFactory(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(dataSource())
            .packages("com.masterkbh.kotlin.common.entity")
            .persistenceUnit("persistenceUnit")
            .properties(jpaProperties().properties)
            .build()
    }
}