package br.com.zup.edu.shared

import br.com.zup.edu.KeyManagerGrpcServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
internal class KeyManagerGrpcClientFactory(@GrpcChannel("keyManager") val channel: ManagedChannel) {

    @Singleton
    fun sayHello() = KeyManagerGrpcServiceGrpc.newBlockingStub(channel)

}