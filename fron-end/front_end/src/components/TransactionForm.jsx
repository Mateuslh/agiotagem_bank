import React, { useState } from 'react';
import UserSelect from './UserSelect';
import styles from './TransactionForm.module.scss';

const TransactionForm = ({ users, onTransaction }) => {
  const [fromUser, setFromUser] = useState('');
  const [toUser, setToUser] = useState('');
  const [amount, setAmount] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onTransaction(fromUser, toUser, parseFloat(amount));
    setFromUser('');
    setToUser('');
    setAmount('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className={styles.formGroup}>
        <label className={styles.label}>De:</label>
        <UserSelect users={users} selectedUser={fromUser} onChange={setFromUser} />
      </div>
      <div className={styles.formGroup}>
        <label className={styles.label}>Para:</label>
        <UserSelect users={users} selectedUser={toUser} onChange={setToUser} />
      </div>
      <div className={styles.formGroup}>
        <label className={styles.label}>Valor:</label>
        <input
          type="number"
          className={styles.input}
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
          min="0"
          required
        />
      </div>
      <button type="submit" className={styles.button}>Enviar</button>
    </form>
  );
};

export default TransactionForm;
