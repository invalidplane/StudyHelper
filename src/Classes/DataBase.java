/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Vector;

/**
 *
 * @author NIRKA
 */
public interface DataBase {
    Vector Read();
    void Update(Vector vec);
    void Create();
    void Delete(Object o);
}
