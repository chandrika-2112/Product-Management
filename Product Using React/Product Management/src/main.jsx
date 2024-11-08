import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import Master from './components/Master'
import './index.css'
import { BrowserRouter } from 'react-router-dom'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
      <Master />
    </BrowserRouter>
  </StrictMode>
)
