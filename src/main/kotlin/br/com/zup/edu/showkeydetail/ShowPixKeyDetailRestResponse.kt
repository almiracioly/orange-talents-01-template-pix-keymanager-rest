package br.com.zup.edu.showkeydetail

import br.com.zup.edu.GetPixKeyDetailResponse

class ShowPixKeyDetailRestResponse(grpcResponse: GetPixKeyDetailResponse) {

    val pixId: String = grpcResponse.pixId
    val keyValue: String = grpcResponse.keyValue
    val keyType: String = grpcResponse.keyType.name
    val owner: OwnerGrpcResponse = OwnerGrpcResponse(grpcResponse.owner)
    val account: AccountGrpcResponse = AccountGrpcResponse(grpcResponse.account)
}

data class OwnerGrpcResponse(val name: String, val cpf: String) {
    constructor(owner: GetPixKeyDetailResponse.OwnerInfo) : this(owner.name, owner.cpf)
}

class AccountGrpcResponse(account: GetPixKeyDetailResponse.AccountInfo) {
    val institution: String = account.institution
    val agencyName: String = account.agencyName
    val accountNumber: String = account.accountNumber
    val accountType: String = account.accountType.name
}
