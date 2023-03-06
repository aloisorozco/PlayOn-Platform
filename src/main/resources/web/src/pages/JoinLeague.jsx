import React, { useContext, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import getId from '../context/account/AccountId'
import AccountPopupContext from '../context/account/AccountPopupContext'
import MyCard from '../components/layouts/MyCard'
import MyForm from '../components/layouts/MyForm'
import AccountContext from '../context/account/AccountContext'

function JoinLeague() {

  const {id} = useContext(AccountContext)
  const [code, setCode] = useState('')
  const navigate = useNavigate()
  const {setMessage} = useContext(AccountPopupContext)

  const joinLeague = (async ({id, code}) => {
    
    const response = await fetch(`http://localhost:8080/league/join`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
         Accept: 'application/json',
         id: id,
      },
      body: JSON.stringify({
        code
      })
    })

    if (response.status >= 400) {
      setMessage('Invalid code')
    }
    else {
      navigate('/main')
    }
  })

  const handleCodeChange = (e) => {
    setCode(e.target.value)
  }

  const inputList = [
    {
      name: "code",
      handleChange: handleCodeChange,
      type: 'text',
    },
  ]

  const link = {
    location: "/main",
    text: "Return to main"
  }

  const handleSubmit = (e) => {
    e.preventDefault()

    if (code === '') {
      //TODO: change to custom alert component
      setMessage('Please enter a code')
    }
    else {
      joinLeague({id, code})
    }
  }

  return (
    <MyCard title='Join League'>
      <form onSubmit={handleSubmit}>
        <MyForm inputlist={inputList} link={link} />
      </form>
      
    </MyCard>   
  )
}

export default JoinLeague