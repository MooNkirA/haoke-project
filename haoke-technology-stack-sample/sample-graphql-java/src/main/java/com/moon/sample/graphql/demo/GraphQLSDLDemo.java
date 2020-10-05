package com.moon.sample.graphql.demo;

import com.moon.sample.graphql.vo.Card;
import com.moon.sample.graphql.vo.User;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * GraphQL 基于 SDL 方式实现示例
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-5 17:38
 * @description
 */
public class GraphQLSDLDemo {

    // GraphQL文件名
    private static final String FILE_NAME = "user.graphqls";

    public static void main(String[] args) throws IOException {
        // 读取GraphQL文件，进行解析
        String fileContent = readFileToString();

        // 定义类型的注册器
        TypeDefinitionRegistry typeRegistry = createTypeDefinitionRegistry(fileContent);

        // 定义数据的查询
        RuntimeWiring wiring = createRuntimeWiring();

        // 定义Schema
        GraphQLSchema graphQLSchema = createGraphqlSchema(typeRegistry, wiring);

        // 创建GraphQL对象实例
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();

        // 注意：查询语句中的user是小写，要和user.graphqls文件中的属性名一致
        String query = "{user(id:10){id,name,age,card{cardNumber,userId}}}";
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
     * 数据的查询
     */
    private static RuntimeWiring createRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("UserQuery", builder ->
                        builder.dataFetcher("user", environment -> {
                            Long id = environment.getArgument("id");
                            Card card = new Card("123456789", id);
                            return new User(id, "新垣结衣的id:" + id, 20 + id.intValue(), card);
                        })
                )
                .build();
    }

    /*
     * 定义类型的注册器
     */
    private static TypeDefinitionRegistry createTypeDefinitionRegistry(String fileContent) {
        return new SchemaParser().parse(fileContent);
    }

    /*
     * 读取文件内容
     */
    private static String readFileToString() throws IOException {
        return IOUtils.toString(GraphQLSDLDemo.class.getClassLoader().getResource(FILE_NAME), "UTF-8");
    }

    /*
     * 定义查询的类型。相当于 Schema 定义数据的结构中
     *  schema { # 定义查询
     *      query: UserQuery
     *  }
     * 返回值查询的类型是 type UserQuery
     */
    private static GraphQLSchema createGraphqlSchema(TypeDefinitionRegistry typeRegistry, RuntimeWiring wiring) {
        return new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
    }

}
