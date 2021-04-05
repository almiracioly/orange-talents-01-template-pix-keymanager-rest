package br.com.zup.edu.storekey

import br.com.zup.edu.KeyManagerGrpcServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import org.slf4j.LoggerFactory
import java.util.*
import javax.validation.Valid

@Controller("/api/v1/clientes/{ownerId}")
open class StoreKeyController(private val grpcStoreKeyClient: KeyManagerGrpcServiceGrpc.KeyManagerGrpcServiceBlockingStub) {

    private val LOGGER = LoggerFactory.getLogger(this::class.java)

    @Post("/pix")
    open fun store(
        ownerId: UUID,
        @Valid @Body request: StoreKeyRequest
    ): HttpResponse<Any> {
        val grpcRequest = request.toGrpcModel(ownerId)
        val grpcResponse = grpcStoreKeyClient.storeKey(grpcRequest)

        return HttpResponse.ok(StoreKeyRestResponse(grpcResponse))
    }
}