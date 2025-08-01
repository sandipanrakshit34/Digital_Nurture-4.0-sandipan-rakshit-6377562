import { configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16'; // you’re using React 19, but Enzyme only works with older versions

configure({ adapter: new Adapter() });
