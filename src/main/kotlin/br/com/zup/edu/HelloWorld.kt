package br.com.zup.edu

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

@Controller
class HelloWorld(private val grpcHelloClient: KeyManagerGrpcServiceGrpc.KeyManagerGrpcServiceBlockingStub) {

    @Get("/hello-world")
    fun hello(@QueryValue("name") name: String): HttpResponse<HelloResponse> {
        val grpcResponse = grpcHelloClient.send(
            KeyManagerGrpcRequest
                .newBuilder()
                .setName(name)
                .build()
        )

        return HttpResponse.ok<HelloResponse>().body(HelloResponse(grpcResponse.message))
    }
}

data class HelloResponse(val message: String)
