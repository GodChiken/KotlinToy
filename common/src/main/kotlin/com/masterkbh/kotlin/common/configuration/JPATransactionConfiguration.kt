package com.masterkbh.kotlin.common.configuration

import org.aspectj.lang.annotation.Aspect
import org.springframework.aop.Advisor
import org.springframework.aop.aspectj.AspectJExpressionPointcut
import org.springframework.aop.support.DefaultPointcutAdvisor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.TransactionManager
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource
import org.springframework.transaction.interceptor.RollbackRuleAttribute
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute
import org.springframework.transaction.interceptor.TransactionInterceptor

@Aspect
@Configuration
class JPATransactionConfiguration(
    private val txManager: TransactionManager
) {
    companion object {
        const val TRANSACTION_METHOD_NAME = "*"
        const val AOP_POINTCUT_EXPRESSION = "execution(* com.masterkbh.kotlin.common.service..*.*(..))"
    }

    @Bean
    fun advice(): TransactionInterceptor {
        val source = MatchAlwaysTransactionAttributeSource()
        val transactionAttribute = RuleBasedTransactionAttribute()
        transactionAttribute.setName(TRANSACTION_METHOD_NAME)
        transactionAttribute.rollbackRules = listOf(RollbackRuleAttribute(Exception::class.java))
        source.setTransactionAttribute(transactionAttribute)
        return TransactionInterceptor(txManager, source)
    }

    @Bean
    fun adviceAdvisor(): Advisor {
        val pointcut = AspectJExpressionPointcut()
        pointcut.expression = AOP_POINTCUT_EXPRESSION
        return DefaultPointcutAdvisor(pointcut, advice())
    }
}