import React from 'react'
import { createContext, useState, useRef, useEffect } from 'react'

const AccountPopupContext = createContext()


export const AccountPopupProvider = ({children}) => {

  const modalRef = useRef(null)

  const [message, setMessage] = useState(null)

  useEffect(() => {
    if (message != null) {
      modalRef.current.checked = true;
    }
    else {
      modalRef.current.checked = false;
    }
  }, message)

  const handleChange = (e) => {
    setMessage(null)
  }

  return (
    <AccountPopupContext.Provider value={{
      message,
      setMessage,
      modalRef,
    }}>
      {children}
      <input type="checkbox" id="my-modal-4" className="modal-toggle" ref={modalRef} onChange={handleChange}/>
      <label htmlFor="my-modal-4" className="modal cursor-pointer">
        {/*TODO: styling + display Message info*/}
        <label className="modal-box w-5/12 relative bg-sky-800" htmlFor="">
          {(message != null) &&
            (<div className='mx-6'>
              <h3 className="text-lg font-bold text-center flex flex-row space-x-2">
                {message}
              </h3>
            </div>)
          }
        </label>
      </label>
    </AccountPopupContext.Provider>
  )
}

export default AccountPopupContext