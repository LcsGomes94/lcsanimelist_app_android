package app.vercel.lcsanimelist.domain.exception

sealed class RepositoryException(message: String, cause: Throwable? = null) : Exception(message, cause) {
    class NetworkException(message: String, cause: Throwable? = null) : RepositoryException(message, cause)
    class DatabaseException(message: String, cause: Throwable? = null) : RepositoryException(message, cause)
    class UnknownException(message: String, cause: Throwable? = null) : RepositoryException(message, cause)
}