/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.tecsup.database;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.database.dao.CursoDAO;
import pe.edu.tecsup.database.model.Curso;

/**
 *
 * @author PCC
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoDAOTest {
    
    @Autowired
    CursoDAO cursoDAO;
    
//    @Test
    public void verifyList() {

        List<Curso> cursos = cursoDAO.list();
        for (Curso curso : cursos) {
            System.out.println(curso.getId());
            System.out.println(curso.getNombre());
            System.out.println(curso.getCodigo());
        }
        Assert.assertTrue(cursos.size() > 0);
    }
    
//    @Test
//    public void verifyFind() {
//        Curso curso = cursoDAO.get(1l);
//        System.out.println(curso.getNombre());
//        Assert.assertTrue(curso.getId() == 1l);
//    }
    
    @Test
    public void verifySave() {

        Curso curso = new Curso();
        curso.setNombre("Nuevo Curso");
        curso.setCodigo("1020");
        
        cursoDAO.save(curso);
        Assert.assertTrue(curso.getId() != null);
    }
    
//    @Test
    public void verifyUpdate() {
        Curso curso = new Curso();
        curso.setId(13l);
        curso.setCodigo("456");
        curso.setNombre("Curso Gilmer 2");

        cursoDAO.update(curso);
        Assert.assertTrue(cursoDAO.get(13l).getNombre().equals("Curso Gilmer 2"));
    }
    
//    @Test
    public void verifyDelete() {

        Curso curso = new Curso();
        curso.setId(17l);
        cursoDAO.delete(curso);

        Assert.assertTrue(cursoDAO.get(17l) == null);
    }
    
    
}
