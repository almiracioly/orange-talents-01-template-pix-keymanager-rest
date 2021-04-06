package br.com.zup.edu.getallownerkeys

import br.com.zup.edu.GetAllPixKeysResponse
import br.com.zup.edu.ResumedPixKeyInfo

class GetAllOwnerKeysRestResponse(grpcResponse: GetAllPixKeysResponse) {
    val pixKeys: List<ResumedPixKeyRestInfo> = grpcResponse.pixKeysList.map { ResumedPixKeyRestInfo(it) }
}

class ResumedPixKeyRestInfo(resumedPixKeyInfo: ResumedPixKeyInfo) {
    val pixId: String = resumedPixKeyInfo.pixId
    val ownerId: String = resumedPixKeyInfo.ownerId
    val keyValue: String = resumedPixKeyInfo.keyValue
}
