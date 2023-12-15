import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './components/App.jsx'
import './static/index.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.js'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import { createBrowserRouter, RouterProvider} from 'react-router-dom'
import { ClienteForm } from './components/forms/ClienteForm.jsx'
import { Cliente } from './components/Cliente.jsx'
import { FuncionarioForm } from './components/forms/FuncionarioForm.jsx'
import { Funcionario } from './components/Funcionario.jsx'
import { Pet } from './components/Pet.jsx'
import { PetForm } from './components/forms/PetForm.jsx'
import { FornecedorForm } from './components/forms/FornecedorForm.jsx'
import { Fornecedor } from './components/Fornecedor.jsx'
import { Produto } from './components/Produto.jsx'
import { ProdutoForm } from './components/forms/ProdutoForm.jsx'
import { ServicoForm } from './components/forms/ServicoForm.jsx'
import { Servico } from './components/Servico.jsx'
import { ItemVendaForm } from './components/forms/ItemVendaForm.jsx'
import { Venda } from './components/Venda.jsx'
import { VendaForm } from './components/forms/VendaForm.jsx'

//rotas do projeto
const router = createBrowserRouter([
  //página principal (home)
  {
    path:"/",
    element:<App /> //algum component
  },
  {
    //todas as rotas de cadastro (post)
    path:"/post",
    children:[
      {
        path:"/post/cliente",
        element:<ClienteForm />
      },
      {
        path:"/post/funcionario",
        element:<FuncionarioForm />
      },
      {
        path:"/post/pet",
        element:<PetForm />
      },
      {
        path:"/post/fornecedor",
        element:<FornecedorForm />
      },
      {
        path:"/post/produto",
        element:<ProdutoForm />
      },
      {
        path:"/post/servico",
        element:<ServicoForm />
      },
      {
        path:"/post/venda",
        element:<ItemVendaForm />
      },
      {
        path:"/post/finalizaVenda",
        element:<VendaForm />
      }
    ]
  },
  {
    //todas as rotas de listar (get)
    path:"/get",
    children:[
      {
        path:"/get/cliente",
        element:<Cliente />
      },
      {
        path:"/get/funcionario",
        element:<Funcionario />
      },
      {
        path:"/get/pet",
        element:<Pet />
      },
      {
        path:"/get/fornecedor",
        element:<Fornecedor />
      },
      {
        path:"/get/produto",
        element:<Produto />
      },
      {
        path:"/get/servico",
        element:<Servico />
      },
      {
        path:"/get/finalizaVenda",
        element:<Venda />
      }
    ]
  }
])
//configuracao queryClient
const queryClient = new QueryClient()

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
      <RouterProvider router={router}/>
    </QueryClientProvider>
  </React.StrictMode>,
)
