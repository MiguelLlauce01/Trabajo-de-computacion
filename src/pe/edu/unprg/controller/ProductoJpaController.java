/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.unprg.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.edu.unprg.controller.exceptions.NonexistentEntityException;
import pe.edu.unprg.entity.Precio;
import pe.edu.unprg.entity.Producto;
import pe.edu.unprg.entity.TipoProducto;

/**
 *
 * @author User
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public ProductoJpaController (){
        this.emf = Persistence.createEntityManagerFactory("Trabajo_ComputacionPU"); 
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Precio precio = producto.getPrecio();
            if (precio != null) {
                precio = em.getReference(precio.getClass(), precio.getIdPrecio());
                producto.setPrecio(precio);
            }
            TipoProducto idTipoProducto = producto.getIdTipoProducto();
            if (idTipoProducto != null) {
                idTipoProducto = em.getReference(idTipoProducto.getClass(), idTipoProducto.getIdTipoProducto());
                producto.setIdTipoProducto(idTipoProducto);
            }
            em.persist(producto);
            if (precio != null) {
                precio.getProductoList().add(producto);
                precio = em.merge(precio);
            }
            if (idTipoProducto != null) {
                idTipoProducto.getProductoList().add(producto);
                idTipoProducto = em.merge(idTipoProducto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            Precio precioOld = persistentProducto.getPrecio();
            Precio precioNew = producto.getPrecio();
            TipoProducto idTipoProductoOld = persistentProducto.getIdTipoProducto();
            TipoProducto idTipoProductoNew = producto.getIdTipoProducto();
            if (precioNew != null) {
                precioNew = em.getReference(precioNew.getClass(), precioNew.getIdPrecio());
                producto.setPrecio(precioNew);
            }
            if (idTipoProductoNew != null) {
                idTipoProductoNew = em.getReference(idTipoProductoNew.getClass(), idTipoProductoNew.getIdTipoProducto());
                producto.setIdTipoProducto(idTipoProductoNew);
            }
            producto = em.merge(producto);
            if (precioOld != null && !precioOld.equals(precioNew)) {
                precioOld.getProductoList().remove(producto);
                precioOld = em.merge(precioOld);
            }
            if (precioNew != null && !precioNew.equals(precioOld)) {
                precioNew.getProductoList().add(producto);
                precioNew = em.merge(precioNew);
            }
            if (idTipoProductoOld != null && !idTipoProductoOld.equals(idTipoProductoNew)) {
                idTipoProductoOld.getProductoList().remove(producto);
                idTipoProductoOld = em.merge(idTipoProductoOld);
            }
            if (idTipoProductoNew != null && !idTipoProductoNew.equals(idTipoProductoOld)) {
                idTipoProductoNew.getProductoList().add(producto);
                idTipoProductoNew = em.merge(idTipoProductoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            Precio precio = producto.getPrecio();
            if (precio != null) {
                precio.getProductoList().remove(producto);
                precio = em.merge(precio);
            }
            TipoProducto idTipoProducto = producto.getIdTipoProducto();
            if (idTipoProducto != null) {
                idTipoProducto.getProductoList().remove(producto);
                idTipoProducto = em.merge(idTipoProducto);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Producto findProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
