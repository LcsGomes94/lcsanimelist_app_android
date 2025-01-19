package app.vercel.lcsanimelist.data.mapper

import app.vercel.lcsanimelist.domain.model.RemoteQueryParameters

fun RemoteQueryParameters.toQueryMap(): Map<String, String> {
    val queryMap = mutableMapOf<String, String>()

    queryMap["limit"] = limit.toString()
    search?.let { queryMap["q"] = it }
    genres?.let {
        queryMap["genres"] = it.joinToString(",") { genre -> genre.id.toString() }
    }
    queryMap["order_by"] = orderBy.name.lowercase()
    queryMap["sort"] = sort.name.lowercase()

    return queryMap
}