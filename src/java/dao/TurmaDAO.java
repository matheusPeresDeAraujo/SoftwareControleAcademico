package dao;

import util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import model.Turma;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TurmaDAO {

    public static void gravar(Turma turma) throws ClassNotFoundException, SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(turma);
        transaction.commit();
        session.close();
    }

    public static void alterar(Turma turma) throws ClassNotFoundException, SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(turma);
        transaction.commit();
        session.close();
    }

    public static void excluir(Turma turma) throws ClassNotFoundException, SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(turma);
        transaction.commit();
        session.close();
    }

    public static Turma obterTurma(int codTurma) throws ClassNotFoundException, SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Turma turma = (Turma) session.load(Turma.class, codTurma);
        session.close();
        return turma;
    }

    public static List<Turma> obterTurmas() throws ClassNotFoundException, SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //List<Turma> turmas = session.createCriteria(Turma.class).list();
        List<Turma> turmas = session.createQuery("from Turma").list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorCurso(int codCurso){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.disciplina.curso.codCurso="+codCurso).list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorAno(Integer ano){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma where ano="+ano).list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorNome(String nome){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.disciplina.nome like '%"+nome+"%'").list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorSemestre(Integer semestre){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma where semestre ="+semestre).list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorSemestreNome(Integer semestre, String nome){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.semestre ="+semestre+" and t.disciplina.nome like '%"+nome+"%'").list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorAnoNome(Integer ano, String nome){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.ano ="+ano+" and t.disciplina.nome like '%"+nome+"%'").list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorAnoSemestre(Integer ano, Integer semestre){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.ano ="+ano+" and t.semestre ="
                +semestre).list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorAnoSemestreNome(Integer ano, Integer semestre, String nome){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.ano ="+ano+" and t.semestre ="
                +semestre+" and t.disciplina.nome like '%"+nome+"%'").list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorCursoNome(Integer curso, String nome){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.disciplina.curso.codCurso ="
                +curso+" and t.disciplina.nome like '%"+nome+"%'").list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorCursoSemestre(Integer curso, Integer semestre){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.disciplina.curso.codCurso ="+curso+" and t.semestre ="+semestre).list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorCursoSemestreNome(Integer curso, Integer semestre, String nome){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.disciplina.curso.codCurso ="+curso+" and t.semestre ="+semestre+" and t.disciplina.nome like '%"+nome+"%'").list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorCursoAno(Integer curso, Integer ano){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.disciplina.curso.codCurso ="+curso+" and t.ano ="+ano).list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorCursoAnoNome(Integer curso, Integer ano, String nome){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.disciplina.curso.codCurso ="+curso+"  and t.ano ="+ano+" and t.disciplina.nome like '%"+nome+"%'").list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorCursoAnoSemestre(Integer curso, Integer ano, Integer semestre){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.disciplina.curso.codCurso ="+curso+"  and t.ano ="+ano+" and t.semestre ="+semestre).list();
        session.close();
        return turmas;
    }
    
    public static List<Turma> obterTurmasPorCursoAnoSemestreNome(Integer curso, Integer ano, Integer semestre, String nome){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Turma> turmas = session.createQuery("from Turma t where t.disciplina.curso.codCurso ="+curso+"  and t.ano ="+ano+"  and t.semestre ="+semestre+" and t.disciplina.nome like '%"+nome+"%'").list();
        session.close();
        return turmas;
    }
    
    
}