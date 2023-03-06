import { createContext, useState } from "react"
import { useNavigate } from "react-router-dom"
import Cookies from "universal-cookie"

const AccountContext = createContext()

const API_URL = `http://localhost:8080`

export const AccountProvider = (({children}) => {

  const [id, setId] = useState(null)

  const onPageLoad = () => {
    const userId = localStorage.getItem('id')
    console.log('onpageload'+userId)
    if (userId) {
      setId(userId)
    }
  }


  return <AccountContext.Provider 
    value={{
      id,
      setId,
      onPageLoad,
    }}
  >
    {children}
  </AccountContext.Provider>

})

export default AccountContext