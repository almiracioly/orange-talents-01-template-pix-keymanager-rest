package br.com.zup.edu.shared

import br.com.zup.edu.KeyManagerGrpcServiceGrpc
import br.com.zup.edu.KeyManagerRemovePixKeyGrpc
import br.com.zup.edu.KeyManagerShowPixKeyDetailGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
internal class KeyManagerGrpcClientFactory(@GrpcChannel("keyManager") val channel: ManagedChannel) {

    @Singleton
    fun sayHello() = KeyManagerGrpcServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun removeKey() = KeyManagerRemovePixKeyGrpc.newBlockingStub(channel)

    @Singleton
    fun showDetail() = KeyManagerShowPixKeyDetailGrpc.newBlockingStub(channel)

}