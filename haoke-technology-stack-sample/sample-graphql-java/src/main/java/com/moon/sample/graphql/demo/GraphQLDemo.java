package com.moon.sample.graphql.demo;

import com.moon.sample.graphql.vo.User;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLLong;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * GraphQL API 编程式实现示例
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-5 16:34
 * @description
 */
public class GraphQLDemo {

    public static void main(String[] args) {
        // 定义对象类型 type User
        GraphQLObjectType userObjectType = createUserObjectType();

        // 定义查询的类型 type UserQuery
        GraphQLObjectType userQueryObjectType = createUserQueryObjectType(userObjectType);

        // 定义Schema
        GraphQLSchema graphQLSchema = createGraphqlSchema(userQueryObjectType);

        // 创建GraphQL对象实例
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();

        // 定义查询的数据结构
        String query = "{user(id:3){id,name,age}}";
        System.out.println("query:" + query);
        // 执行查询
        ExecutionResult result = graphQL.execute(query);

        // 打印错误
        System.out.println("错误：" + result.getErrors());
        // 打印数据
        System.out.println("结果：" + result.getData());
        // 调用toSpecification方法输出标准数据结构
        System.out.println("toSpecification 输出标准数据结构：" + result.toSpecification());
    }

    /*
     * 定义查询的类型。相当于 Schema 定义数据的结构中
     *  schema { # 定义查询
     *      query: UserQuery
     *  }
     * 返回值查询的类型是 type UserQuery
     */
    private static GraphQLSchema createGraphqlSchema(GraphQLObjectType userQueryObjectType) {
        return GraphQLSchema
                .newSchema()
                .query(userQueryObjectType)
                .build();
    }

    /*
     * 定义查询的类型。相当于 Schema 定义数据的结构中
     *  type UserQuery { # 定义查询的类型
     *      user: User # 指定对象以及参数类型
     *  }
     * 返回值查询的类型是 type UserQuery
     */
    private static GraphQLObjectType createUserQueryObjectType(GraphQLObjectType userObjectType) {
        // 定义查询类型中的对象以及参数类型
        GraphQLFieldDefinition userFieldDefinition = createUserFieldDefinition(userObjectType);
        return newObject()
                .name("UserQuery")
                .field(userFieldDefinition)
                .build();
    }

    /*
     * 定义查询的类型。相当于 Schema 定义数据的结构中
     *  type UserQuery { # 定义查询的类型
     *      user: User # 指定对象以及参数类型
     *  }
     * 返回值是查询类型中的参数 user: User
     */
    private static GraphQLFieldDefinition createUserFieldDefinition(GraphQLObjectType userObjectType) {
        return newFieldDefinition()
                .name("user")
                .type(userObjectType)
                // TODO: 使用静态数据，实际会查询数据库获取数据
                // .dataFetcher(new StaticDataFetcher(new User(1L, "石原里美", 30)))
                // 设置查询参数
                .argument(newArgument().name("id").type(GraphQLLong).build())
                .dataFetcher(environment -> {
                    // 获取查询语句中的id参数值
                    Long id = environment.getArgument("id");
                    // TODO: 使用静态数据，实际会根据id查询数据库获取数据
                    return new User(id, "新垣结衣的id:" + id, 20 + id.intValue());
                })
                .build();
    }

    /*
     * 定义User对象类型。相当于 Schema 定义数据的结构中
     *  type User { # 定义对象
     *      id: Long! # !表示该属性是非空项
     *      name: String
     *      age: Int
     *  }
     * 返回值是对象为类型 type User
     */
    private static GraphQLObjectType createUserObjectType() {
        return newObject()
                .name("User")
                .field(newFieldDefinition().name("id").type(GraphQLLong))
                .field(newFieldDefinition().name("name").type(GraphQLString))
                .field(newFieldDefinition().name("age").type(GraphQLInt))
                .build();
    }

}
