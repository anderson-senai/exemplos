package exemplo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import exemplo.jpa.Livro;

public interface LivroRepository extends
JpaRepository<Livro, Long> {
  
      /**
       * Encontra todos os livros de um mesmo autor.
       * 
       * @param autor autor do livro
       * @return lista de livros
       */
      List<Livro> findByAutor(String autor);
       
      /**
  * Encontra um livro a partir do seu t�tulo. 
 * Retorna uma lista pois podem existir
       * mais de um livro com mesmo t�tulo.
       * 
       * @param titulo titulo do livro
       * @return lista de livros
       */
      List<Livro> findByTitulo(String titulo);
       
      /**
* Encontra um livro a partir de seu isbn, como o isbn � �nico, 
apenas um livro pode ser encontrado. 
       * 
       * @param isbn codigo do livro
       * @return livro
       */
      Livro findByIsbn(String isbn);
  
}