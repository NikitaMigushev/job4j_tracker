package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает логику работы банковского сервиса.
 *
 * @author Nikita Migushev
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных о пользователях и их счетах осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя.
     *
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет пользователя. Поиск пользователя осуществляется по паспорту.
     *
     * @param passport
     * @return возвращает true, если пользователь был успешно добавлен, иначе false.
     */

    public boolean deleteUser(String passport) {
        return users.remove(findByPassport(passport)) != null;
    }

    /**
     * Метод добавляет новый счет пользователя. Поиск пользователя осуществляется по поаспорту.
     *
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Метод находит пользователя по паспорту.
     *
     * @param passport
     * @return возвращает найденного пользователя, если пользователь не найдет, то возвращает null.
     */

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод находит счет пользователя по паспорту и номеру счета.
     *
     * @param passport
     * @param requisite
     * @return возвращает найденный счет, если счет не найден, то возвращает null.
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : getAccounts(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод переводит денежные средства со счета отправителя на счет получателя.
     *
     * @param srcPassport   паспорт отправителя
     * @param srcRequisite  номер счета отправителя
     * @param destPassport  паспорт получателя
     * @param destRequisite номер счета получателя
     * @param amount        сумма перевода
     * @return возвращает true в случае успешного перевода, иначе false.
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        return rsl;
    }

    /**
     * Метод находит все счета пользователя
     *
     * @param user
     * @return список счетов пользователя.
     */

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
