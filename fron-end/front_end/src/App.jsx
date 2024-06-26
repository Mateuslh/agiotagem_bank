import React, { useState } from 'react';
import TransactionForm from './components/TransactionForm';
import styles from './App.module.scss';

const App = () => {
  const [users, setUsers] = useState([
    { id: 1, name: 'Alice', balance: 1000 },
    { id: 2, name: 'Bob', balance: 1500 },
    { id: 3, name: 'Charlie', balance: 2000 },
  ]);

  const handleTransaction = (fromUserId, toUserId, amount) => {
    setUsers(prevUsers =>
      prevUsers.map(user => {
        if (user.id === parseInt(fromUserId)) {
          return { ...user, balance: user.balance - amount };
        }
        if (user.id === parseInt(toUserId)) {
          return { ...user, balance: user.balance + amount };
        }
        return user;
      })
    );
  };

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>Sistema de Conta Digital</h1>
      <TransactionForm users={users} onTransaction={handleTransaction} />
      <h2 className={styles.title}>Usuários</h2>
      <ul className={styles.userList}>
        {users.map(user => (
          <li key={user.id} className={styles.userListItem}>
            {user.name}: ${user.balance}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default App;
