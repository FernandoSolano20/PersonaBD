package ac.cr.ucenfotec.bl.factory;

import ac.cr.ucenfotec.bl.Persona.IPersonaDao;

public abstract class DaoFactory {

    public static DaoFactory getDaoFactory(int tipo){
        switch (tipo){
            // es MySql
            case 1: return new MySqlDaoFactory();
            // es SqlServer
            //case 2: return new SqlServerDaoFactory();
            //es Txt
            //case 3: return new TxtDaoFactory();

            default: return null;
        }
    }

    public abstract IPersonaDao getpersonaDao();
    //public abstract IproductoDao getProductoDao();
}
