
package service;

import controller.SalaDAO;
import java.util.List;
import model.Sala;

/**
 *
 * @author Eme
 */
public class SalaService {

    SalaDAO dao = new SalaDAO();

    public List<Sala> obtenerTodasLasSalas() {
        return dao.obtenerTodasLasSalas();
    }
}

