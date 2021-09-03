package com.masterkbh.kotlin.api.graphql.scalar

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsRuntimeWiring
import graphql.scalars.ExtendedScalars
import graphql.schema.idl.RuntimeWiring


@DgsComponent
class ScalarExtendRegistration {
    @DgsRuntimeWiring
    fun addScalar(builder: RuntimeWiring.Builder): RuntimeWiring.Builder {
        return builder.scalar(ExtendedScalars.Date)
                      .scalar(ExtendedScalars.DateTime)
                      .scalar(ExtendedScalars.GraphQLLong)
                      .scalar(ExtendedScalars.GraphQLBigDecimal)
    }
}