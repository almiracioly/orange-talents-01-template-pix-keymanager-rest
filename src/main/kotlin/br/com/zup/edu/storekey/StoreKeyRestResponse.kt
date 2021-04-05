package br.com.zup.edu.storekey

import br.com.zup.edu.StoreKeyResponse

class StoreKeyRestResponse(grpcResponse: StoreKeyResponse) {

    val pixId: String = grpcResponse.pixId

}
