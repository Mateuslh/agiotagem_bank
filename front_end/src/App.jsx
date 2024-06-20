import { useState } from 'react';
import './App.css';

function App() {
  // Opções de destinatários para seleção
  const recipientOptions = [
    { value: 'recipient1', label: 'Destinatário 1' },
    { value: 'recipient2', label: 'Destinatário 2' },
    // Adicione mais conforme necessário
  ];

  // Estado para destinatário selecionado e quantia
  const [selectedRecipient1, setSelectedRecipient1] = useState('');
  const [amount1, setAmount1] = useState('');
  const [selectedRecipient2, setSelectedRecipient2] = useState('');
  const [amount2, setAmount2] = useState('');

  // Função para lidar com o envio das quantias
  const handleSend = () => {
    console.log(`Enviando ${amount1} para ${selectedRecipient1}`);
    console.log(`Enviando ${amount2} para ${selectedRecipient2}`);
    // Resetando os campos após o envio (opcional)
    setSelectedRecipient1('');
    setAmount1('');
    setSelectedRecipient2('');
    setAmount2('');
  };

  return (
    <div className="App">
      <div className="transaction-container">
        {/* Primeira transação */}
        <div className="transaction">
          <select
            value={selectedRecipient1}
            onChange={(e) => setSelectedRecipient1(e.target.value)}
          >
            <option value="">Escolha o Destinatário 1</option>
            {recipientOptions.map((option) => (
              <option key={option.value} value={option.value}>
                {option.label}
              </option>
            ))}
          </select>
          <input
            type="text"
            placeholder="Quantia para Destinatário 1"
            value={amount1}
            onChange={(e) => setAmount1(e.target.value)}
          />
        </div>
        {/* Segunda transação */}
        <div className="transaction">
          <select
            value={selectedRecipient2}
            onChange={(e) => setSelectedRecipient2(e.target.value)}
          >
            <option value="">Escolha o Destinatário 2</option>
            {recipientOptions.map((option) => (
              <option key={option.value} value={option.value}>
                {option.label}
              </option>
            ))}
          </select>
          <input
            type="text"
            placeholder="Quantia para Destinatário 2"
            value={amount2}
            onChange={(e) => setAmount2(e.target.value)}
          />
        </div>
        {/* Botão para enviar */}
        <button onClick={handleSend}>Enviar Quantia</button>
      </div>
    </div>
  );
}

export default App;
