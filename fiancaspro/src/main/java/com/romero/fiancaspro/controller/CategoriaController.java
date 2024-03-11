package com.romero.fiancaspro.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.romero.fiancaspro.model.Categoria;
import com.romero.fiancaspro.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("categoria")
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    CategoriaRepository repository;

    @GetMapping
    public List<Categoria> index() {
        return repository.findAll();

    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria create(@RequestBody Categoria categoria) {
        log.info("Cadastrando categoria {}", categoria);
        repository.save(categoria);
        return categoria;
    
    }
    
}



//     @PostMapping
//     @ResponseStatus(code = HttpStatus.CREATED)
//     public Categoria create(@RequestBody Categoria categoria) { // binding
//         log.info("cadastrando categoria {} ", categoria);
//         repository.add(categoria);
//         return categoria;
//     }

//     @GetMapping("{id}")
//     public ResponseEntity<Categoria> show(@PathVariable Long id) {
//         log.info("buscando categoria por id {}", id);

//         // for(Categoria categoria : repository){
//         // if (categoria.id().equals(id))
//         // return ResponseEntity.ok(categoria);
//         // }

//         var categoriaEncontrada = getCategoriaById(id);

//         if (categoriaEncontrada.isEmpty()) {
//             return ResponseEntity.notFound().build();
//         }

//         return ResponseEntity.ok(categoriaEncontrada.get());

//     }

//     @DeleteMapping("{id}")
//     public ResponseEntity<Object> destroy(@PathVariable Long id) {
//         log.info("apagando categoria");
//         var categoriaEncontrada = getCategoriaById(id);

//         if (categoriaEncontrada.isEmpty()) {
//             return ResponseEntity.notFound().build();
//         }
//         repository.remove(categoriaEncontrada.get());
//         return ResponseEntity.noContent().build();

//     }


//     @PutMapping("{id}")
//     public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria){
//         log.info("atualizando categoria com id {} para {}", id, categoria);
//         // buscar a categoria
//         var categoriaEncontrada = getCategoriaById(id);

//         if (categoriaEncontrada.isEmpty())
//             return ResponseEntity.notFound().build();

//         // criar uma nova categoria com os novos dados
//         var categoriaAntiga = categoriaEncontrada.get();
//         var categoriaNova = new Categoria(id, categoria.nome(), categoria.icone());
        
//         // apagar a categoria antiga
//         repository.remove(categoriaAntiga);

//         // add a categoria nova
//         repository.add(categoriaNova);

//         return ResponseEntity.ok(categoriaNova);
//     }





//     private Optional<Categoria> getCategoriaById(Long id) {
//         var categoriaEncontrada = repository
//                 .stream()
//                 .filter(c -> c.id().equals(id))
//                 .findFirst();
//         return categoriaEncontrada;
//     }

// }