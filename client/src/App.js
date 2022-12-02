import './App.css';
import ForumPage, {ThreadNames} from "./components/ForumPage"
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Thread from "./components/Thread"
import Post from "./components/Post"


function App () {
  return (
      //<div className="App"><FirstPage/></div>
    <div className="App">
    <BrowserRouter>
          <Routes>
            <Route path="/" >
              <Route index element={<ForumPage />} />
              {ThreadNames.map(i =>(
              <Route path={i} element={<Thread props={i}/>} />))}
              <Route path="Post" element={<Post/>} />
            </Route>
          </Routes>
    </BrowserRouter>
  </div>
  );
}
export default App;
/*
{ThreadNames.map(i =>(
  <Route path={ThreadNames[i]} element={<Thread />} />))}
  */