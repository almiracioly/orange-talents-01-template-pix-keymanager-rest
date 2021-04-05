package br.com.zup.edu.showkeydetail

import br.com.zup.edu.GetPixKeyDetailRequest
import br.com.zup.edu.KeyManagerShowPixKeyDetailGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import java.util.*

@Controller("/api/v1/clientes/{ownerId}")
class ShowPixKeyDetailController(private val grpcShowDetailClient: KeyManagerShowPixKeyDetailGrpc.KeyManagerShowPixKeyDetailBlockingStub) {

    @Get("/pix/{pixId}")
    fun show(ownerId: UUID, pixId: UUID): HttpResponse<Any> {
        val grpcResponse = grpcShowDetailClient.showDetail(
            GetPixKeyDetailRequest
                .newBuilder()
                .setPixId(
                    GetPixKeyDetailRequest.FilterByPixId
                        .newBuilder()
                        .setOwnerId(ownerId.toString())
                        .setPixId(pixId.toString())
                        .build()
                )
                .build()
        )

        return HttpResponse.ok(ShowPixKeyDetailRestResponse(grpcResponse))
    }

}