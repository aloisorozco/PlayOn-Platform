import React, { useState, useContext } from 'react'
import { Card} from 'react-daisyui'
import { useNavigate } from 'react-router-dom'
import MyCard from '../components/layouts/MyCard'
import MyForm from '../components/layouts/MyForm'
import AccountPopupContext, { AccountPopupProvider } from '../context/account/AccountPopupContext'

function Register() {

  const [email, setEmail] = useState('')
  const [confirmEmail, setConfirmEmail] = useState('')
  const [password, setPassword] = useState('')
  const [confirmPassword, setConfirmPassword] = useState('')

  const navigate = useNavigate()

  const {setMessage} = useContext(AccountPopupContext)

  const handleEmail = (e) => {
    setEmail(e.target.value)
  }

  const handleConfirmEmail = (e) => {
    setConfirmEmail(e.target.value)
  }

  const handlePassword = (e) => {
    setPassword(e.target.value)
  }

  const handleConfirmPassword = (e) => {
    setConfirmPassword(e.target.value)
  }

  const register = async ({email, password}) => {
    
    const response = await fetch(`http://localhost:8080/account/register`, {
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
      const body = await response.text()
    
      console.log(body)

      if (body != null) {
        navigate('/login')
      }
    }
  }
  
  const inputList = [
    {
      name: "email",
      handleChange: handleEmail,
      type: 'email',
    },
    {
      name: "confirm email",
      handleChange: handleConfirmEmail,
      type: 'email',
    },
    {
      name: "password",
      handleChange: handlePassword,
      type: 'password',
    },
    {
      name: "confirm password",
      handleChange: handleConfirmPassword,
      type: 'password',
    },
  ]

  const handleSubmit = (e) => {
    e.preventDefault()

    if ((email === '' || confirmEmail === '' || password === '' || confirmPassword === '') || (email != confirmEmail) || (password != confirmPassword)) {
      setMessage('Please enter all fields')
    }
    else {
      register({email, password})
    }
  }

  const link = {
    location: '/login',
    text: 'Already have an account? Log in now'
  }

  return (
    <MyCard title='Register'>
      <form onSubmit={handleSubmit}>
      <MyForm inputlist={inputList} link={link} />
      </form>
    </MyCard>    
  )
}

export default Register