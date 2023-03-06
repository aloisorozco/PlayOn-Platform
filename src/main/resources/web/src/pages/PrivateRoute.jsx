import React from 'react'
import { useContext } from 'react'
import {Navigate, Outlet} from 'react-router-dom'
import { useEffect } from 'react'
import { useState } from 'react'
import AccountContext from '../context/account/AccountContext'

function PrivateRoute() {
  const [loading, setLoading] = useState(true)
  const {id, onPageLoad} = useContext(AccountContext)

  useEffect(() => {
    onPageLoad()
    setLoading(false)
  }, [])

  if (!loading) {
    return id ?
        (<Outlet />) :
        (<Navigate to='/' />)
  }
  
}

export default PrivateRoute