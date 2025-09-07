import React, { useState, useEffect } from 'react';
import axios from 'axios';
import MortgageHistory from './MortgageHistory';

const MortgageCalculator = () => {
  const [form, setForm] = useState({
    principal: '',
    annualInterest: '',
    years: '',
  });

  const [result, setResult] = useState(null);
  const [history, setHistory] = useState([]);

  const fetchHistory = async () => {
    try {
      const res = await axios.get('http://localhost:8125/api/mortgage/history');
      setHistory(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  useEffect(() => {
    fetchHistory();
  }, []);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.post(
        'http://localhost:8125/api/mortgage/calculate',
        {
          principal: parseInt(form.principal),
          annualInterest: parseFloat(form.annualInterest),
          years: parseInt(form.years),
        }
      );

      setResult(res.data);
      fetchHistory(); // Refresh history
    } catch (err) {
      console.error(err);
      alert('Error calculating mortgage');
    }
  };

  return (
    <div className='container mt-5'>
      <div className='card p-4 shadow'>
        <h2 className='mb-4'>Mortgage Calculator</h2>
        <form onSubmit={handleSubmit}>
          <div className='mb-3'>
            <label className='form-label'>Principal:</label>
            <input
              type='number'
              className='form-control'
              name='principal'
              value={form.principal}
              onChange={handleChange}
              required
            />
          </div>
          <div className='mb-3'>
            <label className='form-label'>Annual Interest (%):</label>
            <input
              type='number'
              step='0.1'
              className='form-control'
              name='annualInterest'
              value={form.annualInterest}
              onChange={handleChange}
              required
            />
          </div>
          <div className='mb-3'>
            <label className='form-label'>Years:</label>
            <input
              type='number'
              className='form-control'
              name='years'
              value={form.years}
              onChange={handleChange}
              required
            />
          </div>
          <button type='submit' className='btn btn-primary'>
            Calculate
          </button>
        </form>

        {result && (
          <div className='mt-4'>
            <h4>Results</h4>
            <p>
              <strong>Monthly Payment:</strong> $
              {result.monthlyPayment.toFixed(2)}
            </p>
            <h5>Payment Schedule (first 12 months)</h5>
            <ul
              className='list-group mb-4'
              style={{ maxHeight: '200px', overflowY: 'scroll' }}
            >
              {result.paymentSchedule.slice(0, 12).map((balance, i) => (
                <li key={i} className='list-group-item'>
                  Month {i + 1}: ${balance.toFixed(2)}
                </li>
              ))}
            </ul>
          </div>
        )}

        <MortgageHistory history={history} />
      </div>
    </div>
  );
};

export default MortgageCalculator;
