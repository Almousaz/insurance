import React, { useState } from "react";

const MortgageHistory = ({ history }) => {
  const [openId, setOpenId] = useState(null);

  const toggle = (id) => {
    setOpenId(openId === id ? null : id);
  };

  return (
    <div className="mt-5">
      <h3>Mortgage History</h3>
      {history.length === 0 && <p>No history yet.</p>}
      <div className="accordion" id="mortgageHistoryAccordion">
        {history.map((m) => (
          <div className="accordion-item" key={m.id}>
            <h2 className="accordion-header" id={`heading${m.id}`}>
              <button
                className={`accordion-button ${openId === m.id ? "" : "collapsed"}`}
                type="button"
                onClick={() => toggle(m.id)}
              >
                Principal: ${m.principal}, Interest: {m.annualInterest}%, Years: {m.years}, Monthly: ${m.monthlyPayment.toFixed(2)}
              </button>
            </h2>
            <div className={`accordion-collapse collapse ${openId === m.id ? "show" : ""}`}>
              <div className="accordion-body">
                <ul className="list-group">
                  {m.paymentSchedule ? m.paymentSchedule.map((b, i) => (
                    <li key={i} className="list-group-item">
                      Month {i + 1}: ${b.toFixed(2)}
                    </li>
                  )) : <li className="list-group-item">Payment schedule not available.</li>}
                </ul>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default MortgageHistory;
