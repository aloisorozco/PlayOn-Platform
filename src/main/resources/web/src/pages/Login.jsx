import React, { useState, useContext } from 'react'
import { Hero, Card, Form, Input, Button, Link } from 'react-daisyui'
import { useNavigate } from 'react-router-dom'
import MyCard from '../components/layouts/MyCard'
import MyForm from '../components/layouts/MyForm'
import AccountContext from '../context/account/AccountContext'
import Cookies from "universal-cookie"
import AccountPopupContext from '../context/account/AccountPopupContext'

function Login() {

  const navigate = useNavigate()
  const {setId} = useContext(AccountContext)
  const {setMessage} = useContext(AccountPopupContext)

  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  const handleEmailChange = (e) => {
    setEmail(e.target.value)
  }

  const handlePasswordChange = (e) => {
    setPassword(e.target.value)
  }

  const cookies = new Cookies()

  const login = async ({email, password}) => {
    
    const response = await fetch(`http://localhost:8080/account/login`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
         Accept: 'application/json'
      },
      body: JSON.stringify({
        email,
        password,
      })
    })

    if (response.status >= 400) {
      setMessage('Invalid credentials')
    }
    else {
      const id = await response.text()
    
      console.log(id)

      if (id != null) {

        //cookies.set('id', id, {path: '/', expires: new Date(Date.now()+3600)})
        setId(id)
        localStorage.setItem('id', id)
        navigate('/main')
      }
    }
  }

  const inputList = [
    {
      name: "email",
      handleChange: handleEmailChange,
      type: 'email',
    },
    {
      name: "password",
      handleChange: handlePasswordChange,
      type: 'password',
    }
  ]

  const link = {
    location: "/register",
    text: "Don't have an account? Register now"
  }

  const handleSubmit = (e) => {
    e.preventDefault()

    if (email === '' || password === '') {
      //TODO: change to custom alert component
      setMessage('Please enter all fields')
    }
    else {
      login({email, password})
    }
  }

  return (
    <MyCard title='Login'>
      <form onSubmit={handleSubmit}>
        <MyForm inputlist={inputList} link={link} />
      </form>
      
    </MyCard>    
  )
}

export default Login