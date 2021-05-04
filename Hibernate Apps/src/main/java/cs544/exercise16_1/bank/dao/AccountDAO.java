package cs544.exercise16_1.bank.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cs544.exercise16_1.bank.domain.Account;
import cs544.exercise16_1.bank.domain.AccountEntry;
import cs544.exercise16_1.bank.domain.Customer;

public class AccountDAO implements IAccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();
	private SessionFactory sf = HibernateUtils
			.getSessionFactory(Arrays.asList(Account.class, AccountEntry.class, Customer.class));

	public void saveAccount(Account account) {
		Transaction tx = sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(account);
		tx.commit();
		// System.out.println("AccountDAO: saving account with accountnr
		// ="+account.getAccountnumber());
		// accountlist.add(account); // add the new
//-----------------------------------------------------------------------------------------------
//		Session session = null;
//		Transaction tx = null;
//		try {
//			session = HibernateUtils.getSessionFactory(Arrays.asList(Account.class, AccountEntry.class, Customer.class))
//					.openSession();
//			tx = session.beginTransaction();
//			session.saveOrUpdate(account);
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}

	}

	public void updateAccount(Account account) {
		// System.out.println("AccountDAO: update account with accountnr
		// ="+account.getAccountnumber());

//		Account accountexist = loadAccount(account.getAccountnumber());
//		if (accountexist != null) {
//			accountlist.remove(accountexist); // remove the old
//			accountlist.add(account); // add the new
//		}
		Transaction tx = sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().saveOrUpdate(account);
		tx.commit();
//-------------------------------------------------------------------------------		
//		Session session = null;
//		Transaction tx = null;
//		try {
//			session = HibernateUtils.getSessionFactory(Arrays.asList(Account.class, AccountEntry.class, Customer.class))
//					.openSession();
//			tx = session.beginTransaction();
//			session.saveOrUpdate(account);
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}

	}

	public Account loadAccount(long accountnumber) {
		// System.out.println("AccountDAO: loading account with accountnr
		// ="+accountnumber);

//		  for (Account account : accountlist) { 
//			  if (account.getAccountnumber() ==	accountnumber) { 
//				  return account; } 
//			  } return null;
//			  }
		Account account = null;
		Transaction tx = sf.getCurrentSession().beginTransaction();
		account = sf.getCurrentSession().get(Account.class, accountnumber);
		tx.commit();
		return account;

//		Session session = null;
//		Transaction tx = null;
//		
//		try {
//			session = HibernateUtils.getSessionFactory(Arrays.asList(Account.class, AccountEntry.class, Customer.class))
//					.openSession();
//			tx = session.beginTransaction();
//
//			account = session.get(Account.class, accountnumber);
//
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}

	}

	// }

	@SuppressWarnings("unchecked")
	public Collection<Account> getAccounts() {
		// return accountlist;
		List<Account> list = new ArrayList<Account>();
		Transaction tx = sf.getCurrentSession().beginTransaction();
		list = sf.getCurrentSession().createQuery("From Account").list();
		tx.commit();
		return list;
// -------------------------------------------------------------
//		Session session = null;
//		Transaction tx = null;
//		try {
//			session = HibernateUtils.getSessionFactory(Arrays.asList(Account.class, AccountEntry.class,Customer.class)).openSession();
//			tx = session.beginTransaction();
//			list =	session.createQuery("From Account").list();
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}

	}
}
