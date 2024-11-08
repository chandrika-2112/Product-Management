import { useNavigate } from "react-router-dom";
import './Home.css';

const Home = () => {

    const navigate = useNavigate();
   
    const fun_add = () => {
        navigate('/addProduct');
    }
    const fun_view = () => {
        navigate('/viewProducts');
    }


    return(
        <div className="container">
            <h1>Product Management System</h1>

            <div className="btn">
                <button className="styled-button" onClick={fun_add}>
                    Add Product
                </button>

                <button className="styled-button" onClick={fun_view}>
                    View Products
                </button>
            </div>
        </div>
    );

}

export default Home;