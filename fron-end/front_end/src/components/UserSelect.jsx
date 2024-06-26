import React from 'react';
import styles from './UserSelect.module.scss';

const UserSelect = ({ users, selectedUser, onChange }) => {
  return (
    <select
      className={styles.userSelect}
      value={selectedUser}
      onChange={e => onChange(e.target.value)}
    >
      <option value="">Selecione um usuário</option>
      {users.map(user => (
        <option key={user.id} value={user.id}>
          {user.name}
        </option>
      ))}
    </select>
  );
};

export default UserSelect;
