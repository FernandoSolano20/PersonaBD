package ac.cr.ucenfotec.bl.factory;

import ac.cr.ucenfotec.bl.Persona.IPersonaDao;
import ac.cr.ucenfotec.bl.Persona.MySqlPersonaDao;

public class MySqlDaoFactory extends DaoFactory{

    public IPersonaDao getpersonaDao() {
        return new MySqlPersonaDao();
    }
}
