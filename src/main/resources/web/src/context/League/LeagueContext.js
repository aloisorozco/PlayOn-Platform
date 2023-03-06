import { createContext, useReducer } from "react"
import leagueReducer from './LeagueReducer'

const LeagueContext = createContext()

const API_URL = process.env.REACT_APP_API_URL

export const LeagueProvider = (({children}) => {
  const initialState = {
    account: {},
  }

  const [state, dispatch] = useReducer(leagueReducer, initialState)

  return <LeagueContext.Provider 
    value={{
      //TODO
    }}
  >
    {children}
  </LeagueContext.Provider>

})

export default LeagueContext