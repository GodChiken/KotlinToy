package com.masterkbh.kotlin.common.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jmx.export.MBeanExporter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import javax.sql.DataSource

// get yaml properties  :  https://www.baeldung.com/spring-yaml-propertysource
// jdbc connection pool : https://kakaocommerce.tistory.com/45
//                        https://jojoldu.tistory.com/296
// multi db setting     : http://millky.com/@origoni/post/1150
@Configuration
class JPAConfig(private val mBeanExporter: MBeanExporter){

    @Bean
    fun dataSource(): DataSource {
        val dataSource = HikariDataSource(HikariConfig())
        mBeanExporter.addExcludedBean("dataSource")
        return  dataSource
    }

    @Bean
    fun entityManagerFactory(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(dataSource())
            .packages("com.masterkbh.kotlin.common.entity")
            .persistenceUnit("persistenceUnit")
            .build()
    }
}