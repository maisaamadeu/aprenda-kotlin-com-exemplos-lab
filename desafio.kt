// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if(inscritos.contains(usuario)) {
            println("[ERRO] Usuário ${usuario.nome} já matriculado na formação ${nome}.")
        } else {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação ${nome}.")
        }
    }

    fun desmatricular(usuario: Usuario) {
        if(inscritos.contains(usuario)) {
            inscritos.remove(usuario)
            println("Usuário ${usuario.nome} removido da formação ${nome}.")
        } else {
            println("[ERRO] Usuário ${usuario.nome} não encontrado na formação ${nome}.")
        }
    }
}

fun main() {
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    val usuario3 = Usuario("Carol")
    val usuario4 = Usuario("Joana")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 120)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 180)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Android com Kotlin", 240)

    val formacaoBasica = Formacao("Kotlin para Iniciantes", listOf(conteudo1), Nivel.BASICO)
    val formacaoIntermediaria = Formacao("Kotlin Avançado", listOf(conteudo2, conteudo3), Nivel.INTERMEDIARIO)

    formacaoBasica.matricular(usuario1)
    formacaoBasica.matricular(usuario2)
    formacaoIntermediaria.matricular(usuario3)

    formacaoBasica.matricular(usuario1)

    formacaoBasica.desmatricular(usuario1)
    formacaoBasica.desmatricular(usuario4)

    println("\nInscritos na formação ${formacaoBasica.nome}: ${formacaoBasica.inscritos.map { it.nome }}")
    println("Inscritos na formação ${formacaoIntermediaria.nome}: ${formacaoIntermediaria.inscritos.map { it.nome }}")
}
